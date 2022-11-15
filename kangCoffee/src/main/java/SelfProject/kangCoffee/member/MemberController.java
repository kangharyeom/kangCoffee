package SelfProject.kangCoffee.member;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone) {

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED); //
        /*System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);
*/
/*        String response =
                "{\"" +
                        "email\":\""+email+"\"," +
                        "\"name\":\""+name+"\",\"" +
                        "phone\":\"" + phone+
                        "\"}";
        return response;*/
    }
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id")long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public String getMembers() {
        System.out.println("# get Members");

        // not implementation
        return null;
    }
}