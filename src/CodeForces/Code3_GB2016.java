package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

public class Code3_GB2016 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {

        boolean[][] a=new boolean[401][401];
        int[] temp;
        int end;
        int oneX,oneY,twoX,twoY;

        public void solve(InputReader scan, PrintWriter out) {
            int n=scan.nextInt();
            end=n;
            temp=new int[n];
            for (int i = 0; i < n; i++) {
                temp[i]=scan.nextInt();
            }
            find(200,200,0,-1,0);
            int ans=0;
            for(int i=150;i<250;i++){
                for(int j=150;j<250;j++){
                    if(a[i][j]) {
                        ans++;
                        out.print("*");
                    }
                    else out.print("_");


                }
                out.println();
            }
            out.println(ans);

        }

        void find(int x,int y,int dirX,int dirY,int level){
            if(level==end) return;
            fun(dirX,dirY);
            for(int i=0;i<temp[level];i++){
                x+=dirX;y+=dirY;
                a[x][y]=true;
            }
            find(x,y,oneX,oneY,level+1);
            find(x,y,twoX,twoY,level+1);
        }

        void fun(int x,int y){
            if(x==-1&&y==0){
                oneX=-1;twoX=-1;oneY=1;twoY=-1;
            }
            else if(x==1&&y==0) {
                oneX=1;twoX=1;oneY=1;twoY=-1;
            }
            else if(x==1&&y==1){
                oneX=1;twoX=0;oneY=0;twoY=1;
            }
            else if(x==1&&y==-1){
                oneX=1;twoX=0;oneY=0;twoY=-1;
            }
            else if(x==-1&&y==1){
                oneX=-1;twoX=0;oneY=0;twoY=1;
            }
            else if(x==0&&y==-1){
                oneX=-1;twoX=1;oneY=-1;twoY=-1;
            }
            else {
                oneX=1;twoX=-1;oneY=1;twoY=1;
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}