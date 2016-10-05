package RestException;

/**
 *
 * @author miaryvard
 */
public class NotFoundEx extends Exception
{
    public NotFoundEx()
    {
    }
    public NotFoundEx(String msg)
    {
        super(msg);
    }
}
