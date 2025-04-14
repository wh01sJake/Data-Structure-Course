/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arraylistexample;

/**
 *
 * @author Hamilton1
 */
public class Person {
    public String sName;
    public int iAge;

    public Person (String sInName, int iInAge)
    {
        this.sName = sInName;
        this.iAge = iInAge;
    }
    
    public void setsName(String sNewName)
    {
        this.sName= sNewName;
    }
    
    public void setiAge(int iNewAge)
    {
        this.iAge= iNewAge;
    }
    
    public String getsName()
    {
        return sName;
    }
    
    public int getiAge()
    {
        return iAge;
    }
    public String printPerson()
    {
        return sName + " is " + iAge + " years old";
    }

}