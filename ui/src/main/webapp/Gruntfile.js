module.exports = function (grunt) {
	grunt.initConfig({
		bowerRequirejs: {
			dev: {
				rjsConfig: "js/requireConfig.js"
			}
		}
	});

	grunt.loadNpmTasks("grunt-bower-requirejs");
	grunt.loadNpmTasks("grunt-contrib-requirejs");

	grunt.registerTask("build", [
		"bowerRequirejs:dev"
	]);
};
