package net.wanho.controller;

import net.wanho.pjo.RegisterDto;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
public class RegisterDtoController {
    @Autowired
    private StudentServiceI studentServiceI;
    @RequestMapping("registerDto")
    public String registerDto(@Valid RegisterDto registerDto, BindingResult result, Map map){
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String,Object> erroMap=new HashMap<>();
            for(FieldError fieldError : fieldErrors){
                erroMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            map.put("erroe",erroMap);
            return "registerDto";
        }else{
            return "sucess";
        }
    }

    @RequestMapping("toreg")
    public String toreg(){
        int a=1/0;
        return "registerDto";
    }
}
