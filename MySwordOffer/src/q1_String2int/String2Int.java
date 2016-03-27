package que1_String2int;

public class String2Int {
	//参考jdk源码 Integer.parseInt(String str)
	//默认是以基数为10
    public static Integer string2int(String str) 
    		throws NumberFormatException{
    	int result = 0;
    	int i =0;
    	int len = str.length();
    	boolean negative = false;
    	int limit = -Integer.MAX_VALUE;
    	
    	if(len>0){
			//首先处理第一个字符
			Character firstChar = str.charAt(0);
    		if(firstChar<'0'){
    			if(firstChar=='-'){
    				negative=true;
    				limit = -Integer.MIN_VALUE;
    			}else if(firstChar!='+'){
    				throw new  NumberFormatException(str);
    			}
				//如果是“+”或“-”开头，但是只有这一个字符，也不行！
				if(len==1){
    				throw new  NumberFormatException(str);
    			}
				//如果是以“+”或“-”开头，那么错后一位
				i++;
    			
    		}
    		int multilimit = limit /10;
    		while(i<len){
    			///循环地取出每一位的数字，累积相减；
				//每次都进行两步计算：1，乘以基数 2，减去此次取出的数字
				//进行这两部计算之前都要先测试result在计算之后是否超出范围
				int digit = Character.digit(str.charAt(i++), 10);
				if(digit<0){
					throw new NumberFormatException(str);
				}
				
				if(result < multilimit){
					throw new NumberFormatException(str);
				}else{
					//因为是负数，所以作小于的比较；
					//逻辑是：只有小于multi，才能乘以，这样乘以之后的数才安全
					result *=10;
				}
				if(result-digit<limit){
					throw new NumberFormatException(str);					
				}else{
					//因为是负数，所以作小于的比较；
					//逻辑是：只有result-digit小于limit，才能相减，这样减之后的数才安全
					result -=digit;
				}
			}
    	}else{
    		throw new NumberFormatException(str);
    	}	
    	return negative ? result : -result;	
	}

}
