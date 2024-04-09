/**
 * 
 */

let form = {
    $form: $('form#user-save-fome'),
    $action: $('input[name="action"]'),

    user: {
        $id: $('input#user-id'),
        $username: $('input#user-username'),
        $email: $('input#user-email'),
        $password: $('input#user-password'),
        $country: $('select#user-country'),
        $city: $('select#user-city')
    },

    btn: {
        $validate: $('button.btn-validate'),
        $save: $('button.btn-save')
    },

}


let btnValidateClickHandler = (event) => {
    event.preventDefault();
    console.debug('btn validate clicked');
    form.$action.val('validate');
    form.$form.submit();
}

let btnSaveClickHandler = (event) => {
    event.preventDefault();
    console.debug('btn save clicked');
    form.$action.val('save');
    form.$form.submit();
}

let countryChangeHandler = () => {
    let $country = form.user.$country;
    let $city = form.user.$city;

    $city.prop('disabled', true).val('').empty().append($(`<option value="" hidden>Choose a city</option>`));

    if ($country.val()) {
        let countryId = Number($country.val());

        cityService.findAllByCountryId(countryId).done((cities) => {
            console.debug(cities);

            if (cities != null && cities.length > 0) {
                $city.prop('disabled', false);
                cities.forEach((city) => {
                    $city.append($(`<option value="${city.id}">${city.name}</option>`));
                });
            }
        })
    }
}

let main = () => {

    form.btn.$validate.on('click', btnValidateClickHandler);
    form.btn.$save.on('click', btnSaveClickHandler);

    form.user.$country.on('change', countryChangeHandler)

    console.debug('form.js initialized');
}

$(() => {
    main();
})