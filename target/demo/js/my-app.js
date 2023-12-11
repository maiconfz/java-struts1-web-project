class MyApp {
    #$loadingSlash = $('.loading-splash');

    init() {
        console.debug('MyApp initialized...');
        this.applyLinkClickLoadingSplash();
    }

    applyLinkClickLoadingSplash() {
        $('a[href!="#"], button[type="submit"]').click(() => {
            this.loading(true);
        });
    }

    loading(enable) {
        this.#$loadingSlash.prop('hidden', !(enable | this.#$loadingSlash.is(':hidden')));
    }
}

let myApp = new MyApp();

myApp.init();