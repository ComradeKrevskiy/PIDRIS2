package rbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@RestController
public class RBCController {
    @Autowired
    private RBCService service = new RBCService();

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public RBCResponse getRatesNDaysBefore(@RequestBody Integer days) throws ParseException, IOException {
        int daysBefore = days;
        if (days < 1) {
            daysBefore = 1;
        } else if (days > 20) {
            daysBefore = 20;
        }
        List<Double> rateHistory = service.getRates();
        RBCResponse response = new RBCResponse();
        response.value = rateHistory.get(rateHistory.size() - daysBefore);
        return response;
    }

}
