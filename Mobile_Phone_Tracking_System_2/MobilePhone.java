public class MobilePhone
{
  int id;
  Exchange bs;
  Boolean status;
  MobilePhone(int number)
  {
    id=number;
  }
  public int number()
  {
    return id;
  }
  public Boolean status()
  {
    return status;
  }
  public void switchOn()
  {
    status=true;
  }
  public void switchOff()
  {
    status=false;
  }
  public Exchange location()
  {
    return bs;
  }
}