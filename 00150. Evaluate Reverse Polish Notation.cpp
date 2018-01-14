class Solution {
    public:
    int evalRPN(vector<string> &tokens) {
        stack<int> s;
        int size = tokens.size();
        for (int i = 0; i < size; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/" )  {
                int b = s.top(); s.pop();
                int a = s.top(); s.pop();
                int c = 0;
                if (tokens[i] == "+" )
                    c = a+b;
                else if (tokens[i] == "-" )
                    c = a-b;
                else if (tokens[i] == "*" )
                    c = a*b;
                else
                    c = a/b;
                s.push(c);
            }
            else {
                int c = std::atoi(tokens[i].c_str());
                s.push(c);
            }
        }
        int ans = s.top();s.pop();
        return ans;
    }

};