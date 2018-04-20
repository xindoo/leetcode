bool isAnagram(char* s, char* t) {
    int a[26] = {0};
    int b[26] = {0};
    for (int i = 0; s[i] != '\0'; i++) 
        a[s[i]-'a'] +=1;
    for (int i = 0; t[i] != '\0'; i++) 
        b[t[i]-'a'] +=1;
    for (int i = 0; i < 26; i++) {
        if (a[i] != b[i])
            return false;
    }
    return true;
}