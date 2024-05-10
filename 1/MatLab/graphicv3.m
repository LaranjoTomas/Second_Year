fid = fopen("datav3Pedrinho.txt");
c = textscan(fid,'%f%f');
fclose(fid);

YR = cell2mat(c);



h = plot(YR(:,1),YR(:,2), 'o');
hold on
set(h, 'MarkerFaceColor', get(h,'Color'));
title('AED Graph-Sol3-107378')
