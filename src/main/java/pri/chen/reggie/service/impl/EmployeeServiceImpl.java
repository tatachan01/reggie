package pri.chen.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pri.chen.reggie.entity.Employee;
import pri.chen.reggie.mapper.EmployeeMapper;
import pri.chen.reggie.service.EmployeeService;

/**
 * @author long.chen1
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
