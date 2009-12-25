//
// Namespace - Module Pattern.
//
	function InitPageParms(ts){
		$("A[action='Delete']").click(function(){
			var s = $(this);
			var getUrl = $(this).attr('href');
	      $("#Deldialog").clone().dialog({
	        bgiframe: true,
	        resizable: false,
	        height:140,
	        modal: true,
	        overlay: {
	          backgroundColor: '#000',
	          opacity: 0.5
	        },
	        buttons: {
	          '确定': function() {
	            //$(this).dialog('close');
	        	$.get(getUrl); 
	            $(this).remove();
				s.remove();
	          },
	          '取消': function() {
	            //$(this).dialog('close');
	            $(this).remove();
	          }
	        }
	      });	
	      return false;
		});	
	}
var JQD = (function($) {
	return {
		//
		// Initialize the clock.
		//
		init_clock: function() {
			// Date variables.
			var date_obj = new Date();
			var hour = date_obj.getHours();
			var minute = date_obj.getMinutes();
			var day = date_obj.getDate();
			var year = date_obj.getFullYear();
			var suffix = '上午';

			// Array for weekday.
			var weekday = [
				'星期日',
				'星期一',
				'星期二',
				'星期三',
				'星期四',
				'星期五',
				'星期六'
			];

			// Array for month.
			var month = [
				'一月',
				'二月',
				'三月',
				'四月',
				'五月',
				'六月',
				'七月',
				'八月',
				'九月',
				'十月',
				'十一月',
				'十二月'
			];

			// Assign weekday, month, date, year.
			weekday = weekday[date_obj.getDay()];
			month = month[date_obj.getMonth()];

			// AM or PM?
			if (hour >= 12) {
				suffix = '下午';
			}

			// Convert to 12-hour.
			if (hour > 12) {
				hour = hour - 12;
			}
			else if (hour === 0) {
				// Display 12:XX instead of 0:XX.
				hour = 12;
			}

			// Leading zero, if needed.
			if (minute < 10) {
				minute = '0' + minute;
			}

			// Build two HTML strings.
			var clock_time = weekday + ' ' + hour + ':' + minute + ' ' + suffix;
			var clock_date = year + ' ' + month + ', ' + day;

			// Shove in the HTML.
			$('#clock').html(clock_time).attr('title', clock_date);

			// Update every 60 seconds.
			setTimeout(JQD.init_clock, 60000);
		},

		//
		// Clear active states, hide menus.
		//
		clear_active: function() {
			$('a.active, tr.active').removeClass('active ui-state-default');
			$('ul.menu').hide();
		},

		//
		// Zero out window z-index.
		//
		window_flat: function() {
			$('div.window').removeClass('window_stack');
		},

		//
		// Resize modal window.
		//
		window_resize: function(el) {
			// Nearest parent window.
			var win = $(el).closest('div.window');

			// Is it maximized already?
			if (win.hasClass('window_full')) {
				// Restore window position.
				win.removeClass('window_full').css({
					'top': win.attr('data-t'),
					'left': win.attr('data-l'),
					'right': win.attr('data-r'),
					'bottom': win.attr('data-b'),
					'width': win.attr('data-w'),
					'height': win.attr('data-h')
				});
			}
			else {
				win.attr({
					// Save window position.
					'data-t': win.css('top'),
					'data-l': win.css('left'),
					'data-r': win.css('right'),
					'data-b': win.css('bottom'),
					'data-w': win.css('width'),
					'data-h': win.css('height')
				}).addClass('window_full').css({
					// Maximize dimensions.
					'top': '0',
					'left': '0',
					'right': '0',
					'bottom': '0',
					'width': '100%',
					'height': '100%'
				});
			}

			// Bring window to front.
			JQD.window_flat();
			win.addClass('window_stack');
		},

		//
		// Initialize the desktop.
		//
		init_desktop: function() {
			// Start clock.
			JQD.init_clock();

			// Cancel mousedown, right-click.
			$(document).mousedown(function(ev) {
				if (!$(ev.target).closest('a').length) {
					JQD.clear_active();
					//return false;
				}
			}).bind('contextmenu', function() {
				return false;
			});

			// Relative or remote links?
			$('a').click(function() {
				var url = $(this).attr('href');
				this.blur();

				if (url.match(/^#/)) {
					return false;
				}
				else if (url.match('://')) {
					$(this).attr('target', '_blank');
					return true;
				}
			});

			// Make top menus active.
			$('a.menu_trigger').mousedown(function() {
				JQD.clear_active();
				$(this).addClass('active').next('ul.menu').show();
			}).mouseenter(function() {
				// Transfer focus, if already open.
				if ($('ul.menu').is(':visible')) {
					JQD.clear_active();
					$(this).addClass('active').next('ul.menu').show();
				}
			});

			// 桌面 图标
			$('a.icon').mousedown(function() {
				// Highlight the icon.
				JQD.clear_active();
				$(this).addClass('active');
			}).dblclick(function() {
				// Get the link's target.
				var x,y;
				var tar = $(this).attr('href');
				var loadurl = $(this).attr('loadurl');
				if ($($(this).attr('href')).html()==null || $($(this).attr('href')).html()=='undfined' 
					|| $($(this).attr('href')).html()=='')
				{
					var a = $('#icon_dock_computer').clone().attr('id',tar.replace('#',''));
					a.find('a').attr('href',tar.replace('icon_dock','window'));
					$('#bar_bottom').find('#dock').append(a)
				}				
				x = $($(this).attr('href'));				
				//var x = $('#icon_dock_computer');
				if ($(x.find('a').attr('href')).html()==null || $(x.find('a').attr('href'))=='undfined' 
					|| $(x.find('a').attr('href'))=='')
				{
					var a = $('#window_computer').clone().attr('id',tar.replace('#icon_dock','window'));
					a.find('.window_close').attr('href',tar);
					$('#desktop').append(a)
				}								
				y = $(x.find('a').attr('href'));
				
				//var y = $('#window_computer');
				var atitle = $(this).attr('title')

				// Show the taskbar button.
				if (x.is(':hidden')) {
					x.remove().appendTo('#dock').end().show('fast').find('#title').html(atitle);
				}
				//--------------新创建的窗体事件

				y.find('a.window_min').click(function() {
					$(this).closest('div.window').hide();
				});

				// Maximize or restore the window.
				y.find('a.window_resize').click(function() {
					JQD.window_resize(this);
					return false;
				});

				y.mousedown(function() {
					// Bring window to front.
					JQD.window_flat();
					$(this).addClass('window_stack');
				}).draggable({
					// Confine to desktop.
					// Movable via top bar only.
					containment: 'parent',
					handle: 'div.window_top'
				}).resizable({
					containment: 'parent',
					minWidth: 400,
					minHeight: 200

				// Double-click top bar to resize, ala Windows OS.
				}).find('div.window_top').dblclick(function() {
					JQD.window_resize(this);

				// Double click top bar icon to close, ala Windows OS.
				}).find('img').dblclick(function() {
					// Traverse to the close button, and hide its taskbar button.
					$($(this).closest('div.window_top').find('a.window_close').attr('href')).hide('fast');

					// Close the window itself.
					$(this).closest('div.window').hide();

					// Stop propagation to window's top bar.
					return false;
				});				
				
				// Close the window.
				y.find('a.window_close').click(function() {
					$(this).closest('div.window').hide();
					$($(this).attr('href')).hide('fast');
					if ($(this).closest('div.window').attr('id')!='window_computer')
						$(this).closest('div.window').remove();	
					return false;
				});				
				//-------------
				// Bring window to front.
				JQD.window_flat();
				y.addClass('window_stack').show().find('#title').html(atitle);
				 
				y.find('.window_content').load(loadurl);
			}).draggable({
				revert: true,
				containment: 'parent'
			});

			// Taskbar buttons.
			$('#dock a').live('click', function() {
				// Get the link's target.
				var x = $($(this).attr('href'));

				// Hide, if visible.
				if (x.is(':visible')) {
					x.hide();
				}
				else {
					// Bring window to front.
					JQD.window_flat();
					x.show().addClass('window_stack');
				}

				// Stop the live() click.
				this.blur();
				return false;
			});

			// Make windows movable.
			$('div.window').mousedown(function() {
				// Bring window to front.
				JQD.window_flat();
				$(this).addClass('window_stack');
			}).draggable({
				// Confine to desktop.
				// Movable via top bar only.
				containment: 'parent',
				handle: 'div.window_top'
			}).resizable({
				containment: 'parent',
				minWidth: 400,
				minHeight: 200

			// Double-click top bar to resize, ala Windows OS.
			}).find('div.window_top').dblclick(function() {
				JQD.window_resize(this);

			// Double click top bar icon to close, ala Windows OS.
			}).find('img').dblclick(function() {
				// Traverse to the close button, and hide its taskbar button.
				$($(this).closest('div.window_top').find('a.window_close').attr('href')).hide('fast');

				// Close the window itself.
				$(this).closest('div.window').hide();

				// Stop propagation to window's top bar.
				return false;
			});

			// Get action buttons for each window.
			$('a.window_min, a.window_resize, a.window_close').mousedown(function() {
				JQD.clear_active();
				// Stop propagation to window's top bar.
				return false;
			});

			// Minimize the window.
			$('a.window_min').click(function() {
				$(this).closest('div.window').hide();
				return false;
			});

			// Maximize or restore the window.
			$('a.window_resize').click(function() {
				JQD.window_resize(this);
				return false;
			});

			// Close the window.
			$('a.window_close').click(function() {
				if ($(this).closest('div.window').attr('id')!='window_computer')
				$(this).closest('div.window').hide();
				$($(this).attr('href')).hide('fast');
				if ($(this).closest('div.window').attr('id')!='window_computer')
					$(this).closest('div.window').remove();
			});

			// Show desktop button, ala Windows OS.
			$('#show_desktop').click(function() {
				// If any windows are visible, hide all.
				if ($('div.window:visible').length) {
					$('div.window').hide();
				}
				else {
					// Otherwise, reveal hidden windows that are open.
					$('#dock li:visible a').each(function() {
						$($(this).attr('href')).show();
					});
				}
			});

			$('table.data').each(function() {
				// Add zebra striping, ala Mac OS X.
				$(this).find('tr:even td').addClass('zebra');
			}).find('tr').live('click', function() {
				// Highlight row, ala Mac OS X.
				$(this).closest('tr').addClass('active ui-state-default ui-corner-tr');
			});

			/*----------------顶部导航按钮按下创建的新菜单---------------------			*/
			//导航单击
			$("#bar_top>ul A.submenu").mousedown(function() {
				// 高亮桌面图标.
				//JQD.clear_active();
				//$(this).addClass('active');
			}).click(function() {
				// 先获取连接的URL href
				var x,y;
				var loadurl = $(this).attr('href');				
				var tar = $(this).attr('Directory');//这里用目录来代替
				tar = '#icon_dock_' + tar; //需要加工一下				
				if ($(tar).html()==null || $(tar).html()=='undfined' 
					|| $(tar).html()=='')
				{						
					var a = $('#icon_dock_computer').clone().attr('id',tar.replace('#',''));
					a.find('a').attr('href',tar.replace('icon_dock','window'));
					$('#bar_bottom').find('#dock').append(a)
				}					
				x = $(tar);				
				//var x = $('#icon_dock_computer');
				if ($(x.find('a').attr('href')).html()==null || $(x.find('a').attr('href'))=='undfined' 
					|| $(x.find('a').attr('href'))=='')
				{
					var a = $('#window_computer').clone().attr('id',tar.replace('#icon_dock','window'));
					a.find('.window_close').attr('href',tar);
					$('#desktop').append(a)
				}							
				y = $(x.find('a').attr('href'));				
				//var y = $('#window_computer');
				var atitle = $(this).html()+'--';

				// Show the taskbar button.
				if (x.is(':hidden')) {
					x.remove().appendTo('#dock').end().show('fast').find('#title').html(atitle);
				}
				//--------------新窗体的事件
				
				y.find('a.window_min').click(function() {
					$(this).closest('div.window').hide();
					return false;
				});

				// Maximize or restore the window.
				y.find('a.window_resize').click(function() {
					JQD.window_resize(this);
				});

				y.mousedown(function() {
					// Bring window to front.
					JQD.window_flat();
					$(this).addClass('window_stack');
				}).draggable({
					// Confine to desktop.
					// Movable via top bar only.
					containment: 'parent',
					handle: 'div.window_top'
				}).resizable({
					containment: 'parent',
					minWidth: 400,
					minHeight: 200

				// Double-click top bar to resize, ala Windows OS.
				}).find('div.window_top').dblclick(function() {
					JQD.window_resize(this);

				// Double click top bar icon to close, ala Windows OS.
				}).find('img').dblclick(function() {
					// Traverse to the close button, and hide its taskbar button.
					$($(this).closest('div.window_top').find('a.window_close').attr('href')).hide('fast');

					// Close the window itself.
					$(this).closest('div.window').hide();

					// Stop propagation to window's top bar.
					return false;
				});				
				
				// Close the window.
				y.find('a.window_close').click(function() {
					$(this).closest('div.window').hide();
					$($(this).attr('href')).hide('fast');
					if ($(this).closest('div.window').attr('id')!='window_computer')
						$(this).closest('div.window').remove();	
					return false;
				});				
				//-------------
				// 窗体置前.
				JQD.window_flat();
				y.addClass('window_stack').show().find('#title').html(atitle);
				if (loadurl=='AppManager/Application')
					loadurl='AppManager/Applications';
				y.find('.window_content').load(loadurl,{},function(){InitPageParms($(this));});
				
				$(this).parent().parent().hide();				
				return false;
			}).draggable({
				revert: true,
				containment: 'parent'
			});			
			//----------------顶部导航按钮按下创建的新菜单---------------------				
						
			// 桌面背景
			$('body').prepend('<img id="wallpaper" class="abs" src="views/images/misc/wallpaper.jpg" />');
		}
	};
// Pass in jQuery.
})(jQuery);
