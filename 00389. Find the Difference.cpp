class Solution {
public:
    char findTheDifference(string s, string t) {
        int cnt[26] = {0};
        int i = 0;
        while (t[i] != '\0')
        {
            cnt[t[i]-'a']++;
            i++;
        }
        i = 0;
        while (s[i] != '\0')
        {
            cnt[s[i]-'a']--;
            i++;
        }
        int ans = 0;
        for (int j = 0; j < 26; j++)
        {
            if (1 == cnt[j])
            {
                ans = j;
                break;
            }
        }
        return (char)(ans+'a');
    }
};