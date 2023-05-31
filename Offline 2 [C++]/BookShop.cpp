/*******************************Offline 2****************************************/
/* Implement the functions of the class BookShop below as per the instructions  */
/* given inline the class definition. Make sure the output of the code in the   */
/* main function matches the given sample output. You may add/delete codes in   */
/* the main function during your testing. But before submission remove all your */
/* modifications from the main function and submit it as provided initially.    */
/********************************************************************************/

#include<iostream>
#include<cstring>
#include<cmath>
#include "Book.cpp"

using namespace std;

class BookShop
{
    char* name;
    Book* books; //List of books in the shop
    int size;  //maximum number of books the shop can keep
    int count=0; //tracks currently how many numbers in the shop
public:
    void setName(char* Name)
    {
        /*Set the name of the bookshop to the given name*/
        int len = strlen(Name);
        name = new char[len+1];
        strcpy(name,Name);

    }

    BookShop() //Default constructor
    {
        /*Initialize with size 5 and name to empty string ""*/
        books = new Book[5];
        name ="";
    }

    BookShop(char* Name, int Size) //Parameterized constructor
    {
        /*Initialize with the given name and size*/
        size = Size;
        books = new Book[size];
        int len = strlen(Name);
        name = new char[len+1];
        strcpy(name,Name);
    }

    BookShop(const BookShop& bs) //Copy constructor
    {
        /*Write necessary code for the copy constructor*/
        books = new Book[bs.size];
        int len = strlen(bs.name);
        name = new char[len+1];
        strcpy(name,bs.name);
        for(int i =0; i<bs.size; i++)
        {
            books[i] = bs.books[i];
        }
        count = bs.count;
    }

    ~BookShop() //Destructor
    {
        /*Free memory as applicable*/
        delete name;
        delete books;
    }

    void addBook(Book& b)
    {
        /*Add book b to the end of the list*/
        books[count++] = b;
    }

    void addBook(Book* ba, int Count)
    {
        /*Add the given array of books ba to the end of the list*/
        for(int i =0; i<Count; i++)
        {
            books[i] = ba[i];

        }
        count = Count;
    }

    Book getBookInfo(char* Title)
    {
        /*Return the **first** book that has the given title. Assume there is atleast one book in the list with the given title*/
        Book ob;
        for(int i =0; i<count; i++)
        {
            if(!strcmp(books[i].title,Title))
            {
                ob = books[i];
                break;
            }
        }
        return ob;
    }

    void updateBookPrice(int Isbn, int Price)
    {
        /*Update the price of the book with given isbn to the given price*/
        for(int i =0; i<count; i++)
        {
            if(books[i].isbn==Isbn)
                books[i].price = Price;
        }
    }

    void removeBook(int Isbn)
    {
        /*Remove the book with the given isbn from the list. After removing a book all the books below the removed book will be shifted up, i.e, there will be no hole in the list*/
        for(int i =0; i<count; i++)
        {
            if(books[i].isbn==Isbn)
            {
                books[i]=books[i+1];
                count--;
            }
        }
    }

    int totalPrice()
    {
        /*Return the sum of the prices of all the books in the list*/
        int totalPrice =0;
        for(int i =0; i<count; i++)
        {
            totalPrice+=books[i].price;
        }
        return totalPrice;

    }

    void print()
    {
        /*Print the bookshop's name followed by information of all the books in the bookshop*/
        cout<<"Bookshop Name :"<<name<<endl;
        for(int i =0; i<count; i++)
        {
            cout<<"ISBN: "<<books[i].get_isbn()<<",  Title:"<<books[i].get_title()<<",  Price:"<<books[i].get_price()<<endl;
        }
    }

    BookShop mergeShop(BookShop& b)
    {
        /* Return a new bookshop object that will contain all the books of this bookshop and the given bookshop b*/ 			/* Use the title **MergedShop** of the new bookshop	*/
        BookShop ob;
        int i=0,j=0;
        for(; i<count; i++)
        {
            ob.books[i] = books[i];

        }
        for(; j<3; j++)
        {
            ob.books[i+j] = b.books[j];

        }
        ob.count = count + b.count;
        return ob;
    }
};

int main()
{

    BookShop bs1;
    bs1.setName("Boimela");
    Book b1(101,"Teach Yourself C++",100);
    Book b2(102,"Teach Yourself C",200);
    Book b3(103,"Java For Dummies",300);
    bs1.addBook(b1);
    bs1.addBook(b2);
    bs1.addBook(b3);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 100
					ISBN: 102, Title: Teach Yourself C, Price: 200
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */
    cout<<endl;
    cout<<"Total price of books: "<<bs1.totalPrice()<<endl;	/*Output:
															   Total price of books: 600
															*/

    cout<<endl;
    bs1.removeBook(102);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 100
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */

    cout<<endl;
    bs1.updateBookPrice(101,500);
    bs1.print(); /*Output:
					Bookshop Name: Boimela
					ISBN: 101, Title: Teach Yourself C++, Price: 500
					ISBN: 103, Title: Java For Dummies, Price: 300
				 */

    cout<<endl;
    Book jfd=bs1.getBookInfo("Java For Dummies");
    jfd.print();  /*Output:
					 ISBN: 103, Title: Java For Dummies, Price: 300
				 */
    cout<<endl;
    Book ba[3]= {Book(201,"Operating Systems",1000),Book(202,"Compilers",2000),Book(203,"Computer Networks",1500)};
    BookShop bs2("Puthighor",5);
    bs2.addBook(ba,3);
    bs2.print();  /*Output:
					 Bookshop Name: Puthighor
					 ISBN: 201, Title: Operating Systems, Price: 1000
					 ISBN: 202, Title: Compilers, Price: 2000
					 ISBN: 203, Title: Computer Networks, Price: 1500
				 */

    cout<<endl;
    BookShop bs3(bs1.mergeShop(bs2));
    bs3.setName("Mullick Brothers");
    bs3.print(); /*Output:
					Bookshop Name: Mullick Brothers
					ISBN: 101, Title: Teach Yourself C++, Price: 500
					ISBN: 103, Title: Java For Dummies, Price: 300
					ISBN: 201, Title: Operating Systems, Price: 1000
					ISBN: 202, Title: Compilers, Price: 2000
					ISBN: 203, Title: Computer Networks, Price: 1500
				 */

}
