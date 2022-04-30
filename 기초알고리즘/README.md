# 기초 알고리즘1_두 정수 사이의 합


![image](https://user-images.githubusercontent.com/96936431/166110384-4c996361-64d9-4479-9c9b-d9071537899a.png)


```
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
                
        if(-10000000 < a&b <10000000){                   
            if(a < b){
                for(int i=a; i<b+1; i++){
                    answer += i;
                }
            }
            else if(b < a){
                for(int i=b; i<a+1; i++){
                    answer += i;
                }
            }
            else{
                return a;
            }
        }//if
        return answer;
    }//solution
}//class
```
