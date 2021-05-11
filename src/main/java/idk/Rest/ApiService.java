package idk.Rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private String hotelURL = "http://54.227.154.77/";

    private RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HotelModel getHotel(String URL) {
        ResponseEntity<HotelModel> responseEntity =
                restTemplate.exchange(hotelURL + URL, HttpMethod.GET, null, new ParameterizedTypeReference<HotelModel>() {});

        return responseEntity.getBody();
    }
}
