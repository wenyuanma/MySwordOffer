package netease;
//2016.2.26
/*
 * nowcoder 网易笔试题
 * http://www.nowcoder.com/test/question/cee98a512ec246a2918ea8121f7612c8?pid=710847&tid=2459617
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,
 * 若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 */
/*
 * 解题思路：先用用时少的科目把所需的分数填满
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
			//从小的一个个拿出来
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
