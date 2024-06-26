google_ad_url = '';
google_random = (new Date()).getTime();
google_org_error_handler = window.onerror;

function google_write_tracker(tracker_event) {
  var img_url = window.google_ad_url.replace(/pagead\/ads/, 'pagead/imp.gif');
  var img_tag = '<i' + 'mg height=1 width=1 border=0 ' +
                'src=' + img_url +
                '&event=' + tracker_event +
                ' />';
  document.write(img_tag);
}

function google_append_url(param, value) {
  if (value) {
    window.google_ad_url += '&' + param + '=' + value;
  }
}

function google_append_url_esc(param, value) {
  if (value) {
    google_append_url(param, escape(value));
  }
}

function google_append_color(param, value) {
  if (value && typeof(value) == 'object') {
    value = value[window.google_random % value.length];
  }
  google_append_url('color_' + param, value);
}

function google_show_ad() {
  var w = window;
  w.onerror = w.google_org_error_handler;
  w.google_ad_url = 'http://pagead2.googlesyndication.com/pagead/ads?' +
                    'client=ca-' + escape(w.google_ad_client.toLowerCase()) +
                    '&random=' + w.google_random +
                    '&hl=' + w.google_language;

  google_append_url_esc('hints', w.google_hints);
  google_append_url('adsafe', w.google_safe);
  google_append_url('oe', w.google_encoding);
  google_append_url_esc('alternate_ad_url', w.google_alternate_ad_url);

  if (w.google_ad_format) {
    google_append_url_esc('format', w.google_ad_format.toLowerCase());
  }

  google_append_url('num_ads', w.google_max_num_ads);
  google_append_url('output', w.google_ad_output);
  google_append_url('adtest', w.google_adtest);
  google_append_url_esc('url', w.google_page_url);
  google_append_color('bg', w.google_color_bg);
  google_append_color('text', w.google_color_text);
  google_append_color('link', w.google_color_link);
  google_append_color('url', w.google_color_url);
  google_append_color('border', w.google_color_border);
  google_append_url_esc('contents', w.google_contents);

  w.google_ad_url = w.google_ad_url.substring(0, 1000);
  w.google_ad_url = w.google_ad_url.replace(/%\w?$/, '');

  if (google_ad_output == 'js' && w.google_ad_request_done) {
    document.write('<scr' + 'ipt language=JavaScript1.1' +
                   ' src=' + google_ad_url +
                   '></scr' + 'ipt>');
  } else if (google_ad_output == 'html') {
    if (w.name == 'google_ads_frame') {
      google_write_tracker('reboundredirect');
    } else {
      document.write('<ifr' + 'ame' +
                     ' name=google_ads_frame' +
                     ' width=' + w.google_ad_width +
                     ' height=' + w.google_ad_height +
                     ' frameborder=' + w.google_ad_frameborder +
                     ' src=' + w.google_ad_url +
                     ' marginwidth=0' +
                     ' marginheight=0' +
                     ' vspace=0' +
                     ' hspace=0' +
                     ' allowtransparency=true' +
                     ' scrolling=no>');
      google_write_tracker('noiframe');
      document.write('</ifr' + 'ame>');
    }
  }

  w.google_ad_frameborder = null;
  w.google_ad_format = null;
  w.google_page_url = null;
  w.google_language = null;
  w.google_hints = null;
  w.google_safe = null;
  w.google_encoding = null;
  w.google_ad_output = null;
  w.google_max_num_ads = null;
  w.google_contents = null;
  w.google_alternate_ad_url = null;
  w.google_color_bg = null;
  w.google_color_text = null;
  w.google_color_link = null;
  w.google_color_url = null;
  w.google_color_border = null;
  w.google_adtest = null;
}

function google_error_handler(message, url, line) {
  google_show_ad();
  return true;
}

window.onerror = google_error_handler;

if (window.google_ad_frameborder == null) {
  google_ad_frameborder = 0;
}

if (window.google_ad_output == null) {
  google_ad_output = 'html';
}

if (window.google_ad_format == null && window.google_ad_output == 'html') {
  google_ad_format = google_ad_width + 'x' + google_ad_height;
}

if (window.google_language == null) {
  google_language = 'en';
}

if (window.google_page_url == null) {
  google_page_url = document.referrer;
  if (window.top.location == document.location) {
    google_page_url = document.location;
  }
}
google_show_ad();
