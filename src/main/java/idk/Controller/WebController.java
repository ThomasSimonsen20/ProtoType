package idk.Controller;

import idk.Rest.ApiService;
import idk.Rest.HotelModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/FindHotel")
    public String findHotel(WebRequest request, Model model) {
        ApiService apiService = new ApiService(new RestTemplate());

        String hotelURL = request.getParameter("hotelURL");
        HotelModel hotel = apiService.getHotel(hotelURL);

        model.addAttribute("hotel", hotel);

        return "index";
    }
}
