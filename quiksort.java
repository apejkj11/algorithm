class Solution{
	public int[] sortArray(int[] nums){
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	public void quickSort(int[] nums, int start, int end){
		int left = start, right = end;
		if(left >= right) return;
		int pivot = nums[left + (right - left) / 2];
		while(left <= right){
			while(left <= right && nums[left] < pivot) left ++;
			while(left <= right && nums[right] > pivot) right --;
			if(left <= right){
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = nums[right];
				right --;
				left ++;
			}
		}
		quickSort(nums, start, right);
		quickSort(nums, left, end);
	}
}