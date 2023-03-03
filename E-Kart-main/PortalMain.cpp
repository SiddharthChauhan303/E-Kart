#include <bits/stdc++.h>
#include "demo/DemoPortal.h"
// this is the portal file which works on the cpp client
using namespace std;
int main(int argc, char** argv )
{
    char PortalID= *argv[1];
    // cout<<PortalID;
    DemoPortal *dportal = new DemoPortal(PortalID);
    string inp;
    getline(cin,inp);
    // this is the I/O from the client side
    while (inp != "End")
    {
        if(inp!="Check")
        {
            dportal->processUserCommand(inp);
        }
        else 
        {
            dportal->checkResponse();
        }
        getline(cin,inp);
    }
    // this is the file deletion
    ifstream file1, file2;
    file1.open("PlatformToPortal.txt");
    if (file1)
    {
        int status1 = remove("PlatformToPortal.txt");
    }
    file2.open("PortalToPlatform.txt");
    if (file2)
    {
        int status2 = remove("PortalToPlatform.txt");
    }
}
