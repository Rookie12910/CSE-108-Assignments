#include<iostream>
#include<cstring>
#include<cstdlib>
using namespace std;

class Student
{
    char *name;
    int Id;
    int len,newlen;
    float credit_earned, Cgpa;
public:
    Student(char *p, int id, float credit, float cgpa );
    void showInfo();
    void change(char *n);
    void change(int n);
    void addTermResult(float credit, float cgpa);
    ~Student();
};

class Batch
{
    int counter =0;
    Student *batch;
   public:
       Batch();
       ~Batch();
       void addStudent(Student &s);
       void showAllStudents();
};

Student::Student(char *p, int id, float credit, float cgpa)
{
    len = strlen(p);
    name = (char*) malloc(len+1);
    if(!name)
       {
           cout<<"Memory allocation error"<<endl;
           exit(1);
       }
    strcpy(name,p);
    Id = id;
    credit_earned = credit;
    Cgpa = cgpa;
}

Student::~Student()
{
    free(name);
}

void Student::showInfo()
{
    cout<<"Name: "<<name<<", Id: "<<Id<<", Credit Completed: "<<credit_earned<<", Cgpa: "<<Cgpa<<endl;
}

void Student::change(char *n)
{
    newlen = strlen(n);
    name = (char*) realloc(name,newlen+1);
    strcpy(name,n);
}

void Student::change(int n)
{
    Id = n;
}

void Student::addTermResult(float credit, float cgpa)
{
    Cgpa = ((Cgpa*credit_earned)+(credit*cgpa))/(credit_earned+credit);
    credit_earned+=credit;
}

Batch::Batch()
{
  batch = (Student*) malloc(sizeof(Student)*1200);
  if(!batch)
    cout<<"Memory allocation failed"<<endl;
}

Batch::~Batch()
{
    free(batch);
}

void Batch::addStudent(Student &s)
{
  batch[counter] = s;
  counter++;
}

void Batch::showAllStudents()
{
    for( int i =0;i<counter;i++)
    {
        batch[i].showInfo();
    }
}

int main()
{
 // Part 1
 /*A student class holds the information of the
 student name, id, credit earned so far, and
 cumulative gpa (cgpa)*/
 /*The name of a student is stored using malloc,
 which will be freed during destruction*/
 Student s1("Tamim Iqbal", 1905131, 39, 3.56);
 Student s2("Liton Das", 1905150, 39, 3.52);
 s1.showInfo();
 cout<<"Changing the name of s1"<<endl;
 /*During changing the name, you should reallocate
 memory of the new name and free the previously
 allocated memory*/
 s1.change("Tamim Iqbal Khan");
 s1.showInfo();
 cout<<"Changing the id of s2"<<endl;
 s2.change(1905149);
 s2.showInfo();
 cout<<"Adding a term result of s1"<<endl;
 /*The first argument of addTermResult is the credit
 earned in a term and second one is the gpa obtained
 in that term*/
 s1.addTermResult(19, 3.85);
 s1.showInfo();
 // Part 2
 /*Batch contains a list of students*/
 /*During construction, a Batch object allocates dynamic
 memory for 1200 students using malloc. The memory will
 be freed during destruction*/
 Batch b;
 b.addStudent(s1);
 b.addStudent(s2);
 cout<<"Printing the list of students of the batch b"<<endl;
 b.showAllStudents();
}
