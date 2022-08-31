package pri.chen.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pri.chen.reggie.entity.Employee;

/**
 * @author long.chen1
 */

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
