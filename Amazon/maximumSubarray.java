ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        if(n<k)
            return ans;
        //int ap;
        int j=0;
        while(j<=n-k){
            int ap=arr[j];
            for(int i=j; i<j+k; i++){
                if(ap<arr[i])
                    ap=arr[i];
            }
            ans.add(ap);
            j++;
        }
        return ans;