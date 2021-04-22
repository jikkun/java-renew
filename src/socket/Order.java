package socket;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

// 직렬화를 위한 Serializable 상속
@Data
@Builder
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int orderNum;
	private String menu;

}
