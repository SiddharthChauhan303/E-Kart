#include <bits/stdc++.h>
#include "../ecomm/Portal.h"
// .h file for the demo portal
using namespace std;
#ifndef DEMOPORTAL_H
#define DEMOPORTAL_H
// contains all the function definitions and the variables used
class DemoPortal :public Portal{
    public:
    DemoPortal(char PortalID);
    void processUserCommand(string command);
    void checkResponse();
    static int reqID;
    private:
    char PortalID;
};
#endif 