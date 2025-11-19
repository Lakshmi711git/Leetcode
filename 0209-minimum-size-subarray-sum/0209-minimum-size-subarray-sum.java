class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0 ;int s=0; int  m=Integer.MAX_VALUE;
        for ( int r=0;r<nums.length;r++)
        {
            s += nums[r];
            while(s>=target)
            {
                m =Math.min(r-l+1,m);
                s-=nums[l];
                l++;
            }
        }
        return (m==Integer.MAX_VALUE) ? 0: m;
    }
}
