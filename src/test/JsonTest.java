package test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		class A{
			private String name;
			private String age;
		
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getAge() {
				return age;
			}

			public void setAge(String age) {
				this.age = age;
			}
		}
		A a = new A();
		class B {
			private String name;
			private String age;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
			
		}
		
		
		a.setAge("12");
		a.setName("uuu");
		B b = new B();
		b.setAge("16");
		b.setName("qqqq");
		
		List list = new ArrayList();
		list.add(a);
		list.add(b);		
		
		String json = JSON.toJSONString(a);
		String listJson = JSON.toJSONString(list);
		System.out.println(json);
		System.out.println(listJson);
	}

	

}
