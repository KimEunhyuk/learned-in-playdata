# 기초 알고리즘2_수박수박수박수박수박수

![image](https://user-images.githubusercontent.com/96936431/166144871-f367b53c-4151-46b7-b4a8-80b5020c4730.png)

```
class Solution {
    public String solution(int n) {
        String answer = "";
        if(n<10000){
        for(int i=1; i<n+1; i++){
            if(i%2 == 0){
                answer += "박";
            }
            else{
                answer += "수";
            }
        }
        }
        return answer;
    }
}
```
