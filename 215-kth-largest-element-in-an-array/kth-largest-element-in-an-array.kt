class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()

        for(i in 0..nums.size-1){
            pq.add(nums[i])

            if(pq.size >k){
                pq.poll()
            }
        }

        return pq.poll()
    }
}