var require = {
    shim: {
        underscore: {
            exports: "_"
        },
        jquery: {
            exports: "$"
        },
        react: {
            exports: "React"
        },
        reactdom: {
            exports: "ReactDOM"
        }
    },
    packages: [

    ],
	config: {
		babel: {
			sourceMaps: "inline",
			fileExtension: ".jsx"
		}
	},
    paths: {
    	// Remote packages
//        browser: "//cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min",
//        reactdom: "//fb.me/react-dom-15.0.2",
//        react: "//fb.me/react-15.0.2",
//        jquery: "//ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min",

        browser: "../offlinejs/brower",
        reactdom: "../offlinejs/react-dom",
        react: "../offlinejs/react",
        jquery: "../offlinejs/jquery",

        // Manual local package 
        babel: "../bower_components/requirejs-react-jsx/babel-5.8.34.min",
        text: "../bower_components/requirejs-text/text",
        
        // Grunt added packages
        requirejs: "../bower_components/requirejs/require",
        "requirejs-react-jsx": "../bower_components/requirejs-react-jsx/jsx",
        underscore: "../bower_components/underscore/underscore"
    }
};
