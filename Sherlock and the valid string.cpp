#include <bits/stdc++.h>
using namespace std;

int main() {
  set<int> myset;
  string s;
  cin >> s;
  string ans = "NO";

  // cnt[i] stores frequency of character i+'a'
  int cnt[26] = {}, n = s.length();

  for (int i = 0; i < n; i++) {
    // increasing frequency
    cnt[s[i] - 'a']++;
  }

  // for i>=0, it means we are removing character i+'a', if possible
  // case i=-1 is for checking if string is already valid

  for (int i = -1; i < 26; i++) {
    // if character i+'a' is not present in string continue
    if (i >= 0 and cnt[i] == 0)
      continue;

    // reduce frequency
    if (i >= 0)
      cnt[i]--;

    // if we insert all positive frequencies into a set, it should contain
    // only 1 element if string is now valid
    set<int> myset;

    // insert remaining positive frequencies into set
    for (int j = 0; j < 26; j++) {
      if (cnt[j])
        myset.insert(cnt[j]);
    }

    // if set size is 1, string is now valid
    if (myset.size() == 1)
      ans = "YES";

    // increase the frequency back again
    if (i >= 0)
      cnt[i]++;
  }
  cout << ans << endl;
  return 0;
}