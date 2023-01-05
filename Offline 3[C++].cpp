#include<iostream>
#include<cstring>
using namespace std;

class Vector
{
    char *name;
    int x,y,z;
public:
    Vector(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=0;
        y=0;
        z=0;
    }
    Vector(char *n, int a, int b, int c)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=a;
        y=b;
        z=c;
    }
    friend ostream &operator<<(ostream &output, Vector &obj);
    friend Vector operator *(int num, Vector obj);



    int setX(int a)
    {
        x=a;
    }

    int setY(int b)
    {
        y=b;
    }
    int setZ(int c)
    {
        z=c;
    }

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    int getZ()
    {
        return z;
    }

    char *getName()
    {
        return name;
    }

    ~Vector()
    {
        delete []name;
    }

    Vector operator = (Vector obj)
    {
        x = obj.getX();
        y = obj.getY();
        z = obj.getZ();
        return *this;
    }

    Vector (const Vector &obj)
    {
        int l = strlen(obj.name);
        name = new char[l+1];
        strcpy(name,obj.name);
        x=obj.x;
        y=obj.y;
        z=obj.z;
    }
   Vector operator ^(Vector obj)
    {
        Vector temp("");
        temp.x = (y*obj.getZ()) - (z*obj.getY());
        temp.y = -(x*obj.getZ()) + (z*obj.getX());
        temp.z = (x*obj.getY()) - (y*obj.getX());
        return temp;
    }
    int operator ==(Vector obj)
    {
        if(x==obj.getX() && y==obj.getY() && z==obj.getZ())
            return 1;
        else
            return 0;
    }

    Vector operator * (int num)
    {
        Vector temp("");
        temp.setX(x*num);
        temp.setY(y*num);
        temp.setZ(z*num);
        return temp;
    }

    Vector operator * (Vector obj)
    {
        Vector temp("");
        temp.setX(x*obj.getX());
        temp.setY(y*obj.getY());
        temp.setZ(z*obj.getZ());
        return temp;
    }


};

Vector operator * (int num, Vector obj)
{
    Vector temp("");
    temp.x = obj.x * num;
    temp.y = obj.y * num;
    temp.z = obj.z * num;
    return temp;
}

ostream &operator<<(ostream &output, Vector &obj)
{
    cout<<obj.name<<": "<<noshowpos<<obj.x<<"x"<<showpos<<obj.y<<"y"<<showpos<<obj.z<<"z"<<endl;
}

int main()
{
    Vector v1("v1", 1,2,3), v2("v2", 4, 5, -6), v3("Result1"),v4("Result2",-27,18,-3);

    cout << v1;     //Print the components of vector v1
    cout << v2;     //Print the components of vector v2

    v3=v1^v2;       //Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    cout << v3;     //Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      //Check for equality; if two vectors contain equal component values (x, y, z), then they are equal
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    v1= v1*2;       //Multiply each component of vector v1 with the given value
    cout << v1;     //Print the modified components of vector v1

    v2=2*v2;        //Multiply each component of vector v2 with the given value
    cout << v2;     //Print the modified components of vector v2

    v3=v1*v2;       //Multiply each component of vector v1 with the corresponding component of vector v2
    cout << v3;     //Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      //Check for equality; if two vectors contain equal component values (x, y, z), then they are equal
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    return 0;
}

/* Output:
v1: 1x+2y+3z
v2: 4x+5y-6z
Result1: -27x+18y-3z
Vectors are equal
v1: 2x+4y+6z
v2: 8x+10y-12z
Result1: 16x+40y-72z
Vectors are not equal
*/
