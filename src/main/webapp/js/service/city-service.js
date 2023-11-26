/**
 * 
 */
class CityService {
    findAllByCountryId(countryId) {
        let $def = $.Deferred();

        $.get('/MyApp/api/city/by-country.do', {
            "countryId": countryId
        }, (res) => {
            $def.resolve(res.cities);
        }).fail(() => {
            $def.reject();
        });

        return $def.promise();
    }
}

let cityService = new CityService();

console.debug('city-service.js initialized');