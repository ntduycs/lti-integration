package duy.nguyen.lti.api;

import duy.nguyen.lti.core.oidc.OidcLoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OidcController {
    @RequestMapping(path = "/oidc/login", method = {GET, POST})
    public void loginEndpoint(@RequestBody OidcLoginRequest oidcLoginRequest) {

    }
}
