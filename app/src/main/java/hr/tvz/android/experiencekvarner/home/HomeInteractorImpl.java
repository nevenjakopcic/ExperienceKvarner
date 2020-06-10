package hr.tvz.android.experiencekvarner.home;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.experiencekvarner.model.CityModel;

public class HomeInteractorImpl implements IHomeMVP.Interactor {

    List<CityModel> cities;

    @Override
    public void findCities(IHomeMVP.Interactor.OnFinishedListener listener) {
        cities = getDummyCities();
        listener.onFinished();
    }

    private List<CityModel> getDummyCities() {
        List<CityModel> dummyList = new ArrayList<>();
        dummyList.add(new CityModel(1L, "Rijeka"));
        dummyList.add(new CityModel(2L, "Senj"));
        dummyList.add(new CityModel(3L, "Krk"));
        dummyList.add(new CityModel(4L, "Rab"));

        return dummyList;
    }

    @Override
    public CityModel getCity(int position) {
        return cities.get(position);
    }

    @Override
    public int rowCount() {
        return cities.size();
    }

    @Override
    public void onDestroy() {
        cities = null;
    }
}
