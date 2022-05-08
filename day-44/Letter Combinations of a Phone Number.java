class Solution 
{
    String map[] = {"","", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
    {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0)
            return ans;
        
        solve(digits, 0, new StringBuilder(), ans);
        
        return ans;    
    }
    private void solve(String digits, int i, StringBuilder sb, List<String> ans)
    {
        if(i == digits.length())
        {
            ans.add(sb.toString());
            return;
        }
        int index = digits.charAt(i) -'0';
        String curr = map[index];
        for(int k = 0; k < curr.length(); k++)
        {
            sb.append(curr.charAt(k));
            solve(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}