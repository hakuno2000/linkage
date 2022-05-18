package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.DTO.MPOSAuthorizeDTO;
import com.bglobal.linkage.DTO.MPOSLoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Service
public class LinkageServiceImpl implements LinkageService {
    WebClient webClient = WebClient.create();
    String cookie = "";

    @Value("${MPOS_URI}")
    private String mposUri;
    @Value("${CLIENT_ID}")
    private String clientId;
    @Value("${LINKAGE_USERNAME}")
    private String linkageUsername;
    @Value("${LINKAGE_PASSWORD}")
    private String linkagePassword;

    private String accessToken = "";
    private String refreshToken = "";
    private String scope;

    @Override
    public MPOSLoginDTO loginToMPOS() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/linkage/login.json")
                .queryParam("login_nm", this.linkageUsername)
                .queryParam("login_pw", this.linkagePassword)
                .queryParam("client_id", this.clientId)
                .encode()
                .build(true).toUri();

        ResponseEntity<MPOSLoginDTO> response = webClient.post()
                .uri(uri)
                .retrieve()
                .toEntity(MPOSLoginDTO.class).block();

        assert response != null;
        HttpHeaders headers = response.getHeaders();
        cookie = headers.getFirst("Set-Cookie");
        assert cookie != null;
        int firstIndex = cookie.indexOf(";");
        cookie = cookie.substring(0, firstIndex);
//        System.out.println("Cookie = " + cookie);

        MPOSLoginDTO responseBody = response.getBody();
        assert responseBody != null;
        this.scope = responseBody.getScope();
        return responseBody;
    }

    @Override
    public MPOSAuthorizeDTO authorizeMPOS() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/provider/authorize.json")
                .queryParam("client_id", this.clientId)
                .queryParam("response_type", "code")
                .queryParam("scope", this.scope)
                .encode()
                .build(false).toUri();

//        System.out.println(uri.toString());
        System.out.println("Cookie = " + cookie);

        MPOSAuthorizeDTO response = webClient.post()
                .uri(uri)
                .header("Cookie", cookie)
//                .accept(MediaType.TEXT_HTML)
//                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve()
                .bodyToMono(MPOSAuthorizeDTO.class).block();

        return response;
    }

    @Override
    public List<LinkageResponseCategoryDTO> findCategoriesByCommonCode(String categoryCode, String accessToken) {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(System.getenv("MPOS_URI")).path("/dev/v1").path("/commoncode/category/read.json")
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageResponseCategoryDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageResponseCategoryDTO.class);

        return response.collectList().block();
    }
}
