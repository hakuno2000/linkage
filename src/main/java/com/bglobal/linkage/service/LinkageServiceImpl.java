package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.LinkageResponseCategoryDTO;
import com.bglobal.linkage.DTO.MPOSLoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;

@Service
public class LinkageServiceImpl implements LinkageService {
    WebClient webClient = WebClient.create();

    @Override
    public MPOSLoginDTO loginToMPOS() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host("54.238.233.54").path("/dev/v1").path("/linkage/login.json")
                .queryParam("login_nm", "lk_user1")
                .queryParam("login_pw", "lk_user1")
                .queryParam("client_id", "Z6aY9vwAx1.api.linkage")
                .encode()
                .build(true).toUri();

//        System.out.println(uri.toString());

        MPOSLoginDTO response = webClient.post()
                .uri(uri)
                .retrieve()
                .bodyToMono(MPOSLoginDTO.class).block();

        return response;
    }

    @Override
    public List<LinkageResponseCategoryDTO> findCategoriesByCommonCode(String categoryCode, String accessToken) {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host("54.238.233.54").path("/dev/v1").path("/commoncode/category/read.json")
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
