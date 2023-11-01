package Repository;
import DataAccess.LNSDao;

import java.io.IOException;

public class LNSRepository implements ILNSRepository{
    @Override
    public void actionCW() {
        LNSDao.actionCW();
    }

    @Override
    public void actionFF() {
        LNSDao.actionFF();
    }
}
