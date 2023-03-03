// this is the .h file for the portal.cpp file
// contains all the function definitions and variables used
#include <bits/stdc++.h>
using namespace std;
#ifndef PORTAL_H
#define PORTAL_H
class Portal {
    public:
    virtual void processUserCommand(string command);
    virtual void checkResponse();
};
#endif 