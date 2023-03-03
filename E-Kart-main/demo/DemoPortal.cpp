#include <bits/stdc++.h>
#include "DemoPortal.h"
#include"../ecomm/Portal.h"
using namespace std;
// this is the cpp side of the portal client
int DemoPortal :: reqID = 1;
DemoPortal :: DemoPortal(char PortalID)
{
    this->PortalID = PortalID;
}
// this is the processUsercommand func which creates a new file based on each new customer which sends a request 
void DemoPortal::processUserCommand(string command){
    fstream fio;
    string s(1, PortalID);
    string portalID = "P"+s;
    fio.open("PortalToPlatform.txt", ios::in|ios::app);
    fio << portalID << " " << reqID << " " << command << endl;
    reqID++;
    fio.close();
};
// this function performs all the file handling after recieving a response from the java side of the client
void DemoPortal::checkResponse()
{
    vector<string> arr;
    string line;
    fstream fh;
    fh.open("PlatformToPortal.txt", ios::out | ios::in);
    while (fh)
    {
        getline(fh, line);
        if (line[1]==PortalID)
        {
            if(line!= "\n")
            cout << line << endl;
        }
        else 
        {
            arr.push_back(line);
        }
    }
    // this deletes and recreates the file again after each request sent by any customer 
    int status = remove("PlatformToPortal.txt");
    fh.close();
    fstream fio;
    fio.open("PlatformToPortal.txt", ios::in|ios::app);
    for (int i = 0; i < arr.size(); i++)
    {
        fio << arr[i] << endl;
    }
    fio.close();
};

