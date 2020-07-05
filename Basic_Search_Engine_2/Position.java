public class Position
{
	int wordIndex;
	PageEntry p;
	Position(PageEntry p, int wordIndex)
	{
      this.wordIndex=wordIndex;
      this.p=p;
	}
	public PageEntry getPageEntry()
	{
        return this.p;
	}
	public int getWordIndex()
	{
		return this.wordIndex;
	}
}