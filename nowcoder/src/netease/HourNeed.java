package netease;
//2016.2.26
/*
 * nowcoder ���ױ�����
 * http://www.nowcoder.com/test/question/cee98a512ec246a2918ea8121f7612c8?pid=710847&tid=2459617
 * Сv������n�ſΣ�ÿ�Ŷ��п��ԣ�Ϊ���õ���ѧ��Сv�������Լ���ƽ���ɼ�����Ϊavg��
 * ÿ�ſ���ƽʱ�ɼ��Ϳ��Գɼ���ɣ�����Ϊr��������֪��ÿ�ſε�ƽʱ�ɼ�Ϊai ,
 * ���������ſεĿ��Գɼ�����һ�ֵĻ���СvҪ��bi ��ʱ�临ϰ������ϰ�Ļ���Ȼ����0�֡�
 * ͬʱ������Ȼ���Է��ָ�ϰ���ٶ�Ҳ�����õ��������ֵķ�����Ϊ���õ���ѧ��Сv����Ҫ������ʱ�临ϰ��
 */
/*
 * ����˼·��������ʱ�ٵĿ�Ŀ������ķ�������
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HourNeed {
    class Subject{
    	int hour;
    	int need;
    	Subject(int hour,int need){
    		this.hour = hour;
    		this.need = need;
    	}
    }
    public static void main(String[] args){
    	HourNeed hn = new HourNeed();
    	System.out.println(hn.calculate());
    }
	public int calculate() {
		// TODO Auto-generated method stub
		int hourneed = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		int avg = in.nextInt();
		int gotsum = 0;
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			gotsum += a;
			Subject sub = new Subject(b,r-a);
			subjects.add(sub);
		}
		int scoreneed = avg*n-gotsum;
		Collections.sort(subjects,new Comparator<HourNeed.Subject>(){
			@Override
			public int compare(HourNeed.Subject sub1,HourNeed.Subject sub2) {
				if(sub1.hour<sub2.hour){
					return -1;
				}else if(sub1.hour>sub2.hour){
					return 1;
				}else{
					if(sub1.need<sub2.need){
						return -1;
					}else{
						return 1;
					}
				}		
			}	
		});
		for(Subject sub: subjects){
			//��С��һ�����ó���
			if(scoreneed >= sub.need){
				hourneed += sub.need*sub.hour;
				scoreneed -= sub.need;
			}else{
				hourneed += scoreneed*sub.hour;
				scoreneed = 0;
			}
			if (scoreneed <= 0) break;
		}
		return hourneed;
	}

}
