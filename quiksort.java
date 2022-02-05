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


//template
class Solution{
	public int[] sortArray(int[] nums){
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	public void quickSort(int[] nums, int left, int right){
		if(left >= right) return;
		int pivot = partition(nums, left, right);
		quickSort(nums, left, pivot - 1);
		quickSort(nums, pivot + 1, right);
	}
	
	public int partition(int[] nums, int left, int right){
		int pivot = nums[right];
		int start = left, end = pivot -1;
		while(start <= end){
			if(nums[start] <= pivot) {
				start ++;
			}else if (nums[end] > pivot){
				end --;
			}else{
				swap(nums, start++, end--);
			}
		}
		swap(nums, start, right);
		return start;
	}
	
	public int partition2(int[] nums, int left, int right){
		int pivot = nums[right], wall = left;
		for(int i = left; i < right; i ++){
			if(nums[i] < pivot){
				swap(nums, i, wall);
				wall++;
			}
		}
		swap(nums, wall, right);
		return wall;
	}
}