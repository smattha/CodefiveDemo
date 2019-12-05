package com.skyroof.web;

import com.skyroof.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FirstGetMethod {

    //to map einai to interface, to hashmap einai to implementation
    private Map<Long, Employee> ALL_EMPLOYEES = new HashMap<Long, Employee>() {{
        put(1L, new Employee(1L, "George", "Olympioy"));
        put(2L, new Employee(2L, "Bill", "Gates"));
        put(3L, new Employee(3L,"Larry", "Ellison"));
    }};

    @GetMapping("/findEmployee/{id}")
    public Employee first(@PathVariable("id") Long employeeId) {
        return ALL_EMPLOYEES.getOrDefault(employeeId, new Employee());
    }

    @GetMapping("/findEmployee2/{id}")
    public Employee second(@PathVariable("id") Long employeeID ) {
        Employee employee = ALL_EMPLOYEES.get(employeeID);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    @PostMapping("/firstpost")
    public @ResponseBody MyResponse firstpostmethod(@RequestBody MyRequest myRequest) {
        System.out.println(myRequest); //kaleitai aytomata i toString()
        MyResponse ok = new MyResponse("OK", "");
        if (myRequest.getAge() < 18) {
            ok.setAgeType(AgeType.UNDER_18);
        }
        else ok.setAgeType(AgeType.ADULT);
        System.out.println(ok);
        return ok;
    }

//    @GetMapping("/first")
//    public MyResponse first() {
//        return new MyResponse("OK", "Καλώς!!!");
//    }
//
//    @GetMapping("/second")
//    public List<MyResponse> second() {
////        return Arrays.asList(new MyResponse[]{new MyResponse("OK", "Πάσα πάσα σουτ!!!"),
////                new MyResponse("OK", "Πάσα πάσα σουτ!!!"),
////                new MyResponse("OK", "Πάσα πάσα σουτ!!!"),
////                new MyResponse("OK", "Πάσα πάσα σουτ!!!")}) ;
//           MyResponse ok = new MyResponse("OK", "Πάσα πάσα σουτ!!!");
//           //ok.setSubMyResponse(new SubMyResponse("666"));
//           return Arrays.asList(ok, ok, ok, ok);
//    }

//enallaktika
//    MyResponse ok = new MyResponse("OK", "Πάσα πάσα σουτ!!!");
//      ok.setSubMyResponse("666");
//    return Arrays.asList(ok, ok, ok, ok);
}
