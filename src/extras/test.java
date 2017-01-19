package extras;

class test {
    public static void main(String[] args) {
        test test = new test();
        test.solve();
    }

    private void solve() {
        int[] a={5,8,59,-4,7,0,9};
        sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    private void sort(int[] a, int low, int high) {
        if(low==high) return;
        int mid=(low+high)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,low,high,mid);
    }

    private void merge(int[] a, int low, int high, int mid) {
        int [] temp=a.clone();
        int i=low;
        int j=mid+1;
        int count=low;
        while (i<=mid&&j<=high){
            if(temp[i]<temp[j]){
                a[count]=temp[i++];
            }
            else a[count]=temp[j++];
            count++;
        }
        while (i<=mid){
            a[count]=temp[i++];
            count++;
        }
        while (j<=high){
            a[count]=temp[j++];
            count++;
        }
    }

}