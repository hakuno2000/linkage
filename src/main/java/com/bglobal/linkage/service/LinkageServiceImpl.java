package com.bglobal.linkage.service;

import com.bglobal.linkage.DTO.*;
import com.bglobal.linkage.table.TableActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Service
public class LinkageServiceImpl implements LinkageService {
    @Autowired
    private ShopMappingService shopMappingService;

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
//        System.out.println("Cookie = " + cookie);

        MPOSAuthorizeDTO response = webClient.post()
                .uri(uri)
                .header("Cookie", cookie)
//                .accept(MediaType.TEXT_HTML)
//                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve()
                .bodyToMono(MPOSAuthorizeDTO.class).block();

        assert response != null;
        System.out.println("access token = " + response.getAccessToken());
        accessToken = response.getAccessToken();
        refreshToken = response.getRefreshToken();
        return response;
    }

    @Override
    public Integer getShopIdByShopCode(String shopCode) {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/shop/read.json")
                .queryParam("shop_codes", shopCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Mono<ShopDTO> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ShopDTO.class);
        ShopDTO shopDTO = response.block();
        if (shopDTO == null) return null;
        return shopDTO.getShopId();
    }

    @Override
    public List<LinkageRequestCategoryDTO> findCategoriesByCommonCode(String shopCode, Integer serviceId, String categoryCode) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/category/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("category_codes", categoryCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageRequestCategoryDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageRequestCategoryDTO.class);

        return response.collectList().block();
    }

    @Override
    public List<LinkageRequestItemDTO> findItemsByCommonCode(String shopCode, Integer serviceId, String itemCode) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/item/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("item_codes", itemCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageRequestItemDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageRequestItemDTO.class);

        return response.collectList().block();
    }

    @Override
    public List<LinkageRequestItemDetailDTO> findItemDetailsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/item/detail/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("item_detail_codes", itemDetailCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageRequestItemDetailDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageRequestItemDetailDTO.class);

        return response.collectList().block();
    }

    @Override
    public List<LinkageRequestItemDetailContentDTO> findItemDetailContentsByCommonCode(String shopCode, Integer serviceId, String itemDetailCode, String itemDetailContentCode) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/item/detail/content/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("item_detail_content_codes", itemDetailContentCode)
                .queryParam("item_detail_codes", itemDetailCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageRequestItemDetailContentDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageRequestItemDetailContentDTO.class);

        return response.collectList().block();
    }

    @Override
    public List<LinkageRequestTableDTO> findTablesByCommonCode(String shopCode, Integer serviceId, String tableCode) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/commoncode/table/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("table_codes", tableCode)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<LinkageRequestTableDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(LinkageRequestTableDTO.class);

        return response.collectList().block();
    }

    @Override
    public List<TableActivityDTO> findTableActivitiesByCommonCode(String shopCode, Integer serviceId, String tableActivityCode, String tableCode, String ownerId) {
        Integer shopId = shopMappingService.getShopIdByShopCode(shopCode);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http").host(this.mposUri).path("/dev/v1").path("/linkage/table/activity/read.json")
                .queryParam("shop_id", shopId)
                .queryParam("service_id", serviceId)
                .queryParam("table_codes", tableCode)
                .queryParam("table_activity_code", tableActivityCode)
                .queryParam("owner_id", ownerId)
                .queryParam("access_token", accessToken)
                .encode()
                .build(true).toUri();

        Flux<TableActivityDTO> response = webClient.get()
                .uri(uri)
                .header("Authorization", accessToken)
                .retrieve()
                .bodyToFlux(TableActivityDTO.class);

        return response.collectList().block();
    }
}
