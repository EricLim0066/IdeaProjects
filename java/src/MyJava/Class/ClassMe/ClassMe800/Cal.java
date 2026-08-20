package MyJava.Class.ClassMe.ClassMe800;

public class Cal {
    //带三个参数
    public int CalData(int num1,int num2,char oper) {       //三个参数
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;                         //加break防止case穿透
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = -1;                //协议，输出-1证明除数为0
                }
                break;
            default:                            //default假设case都不匹配
                result = -2;                    //操作符错误
                break;
        }
        return result;
    }
}
