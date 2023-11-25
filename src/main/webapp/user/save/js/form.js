/**
 * 
 */

let form = {
    $form: $('form#user-save-fome'),
    btn: {
        $validate: $('button.btn-validate'),
        $save: $('button.btn-save')
    },

}


let btnValidateClickHandler = (event) => {
    event.preventDefault();
    console.debug('btn validate clicked');

    form.$form.submit();
}

let btnSaveClickHandler = (event) => {
    event.preventDefault();
    console.debug('btn save clicked');

    form.$form.submit();
}

let main = () => {

    form.btn.$validate.click(btnValidateClickHandler);
    form.btn.$save.click(btnSaveClickHandler);

    console.debug('form.js initialized');
}

$(() => {
    main();
})