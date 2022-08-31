package pri.chen.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import pri.chen.reggie.common.R;
import pri.chen.reggie.entity.Employee;
import pri.chen.reggie.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author long.chen1
 */

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        String password = employee.getPassword();

        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> query = new LambdaQueryWrapper<Employee>();

        query.eq(Employee::getUsername, employee.getUsername());

        Employee empResult = employeeService.getOne(query);

        if (empResult == null) {
            return R.error("登录失败");
        }

        if (!empResult.getPassword().equals(password)) {
            return R.error("登录失败");
        }

        if (empResult.getStatus() == 0) {
            return R.error("账号以禁用");
        }

        request.getSession().setAttribute("employee", empResult.getId());
        return R.success(empResult);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

}
